document.addEventListener('DOMContentLoaded', () => {
    const fileInput = document.getElementById('fileInput');
    const imageLinkContainer = document.getElementById('imageLinkContainer');

    fileInput.addEventListener('change', async (event) => {
        const file = event.target.files[0];
        if (file) {
            await uploadImage(file);
        }
    });

    async function uploadImage(file) {
        const apiKey = 'YOUR_IMGBB_API_KEY';
        const url = 'https://api.imgbb.com/1/upload';
        const formData = new FormData();

        formData.append('image', file);

        try {
            const response = await fetch(`${url}?key=${apiKey}`, {
                method: 'POST',
                body: formData
            });
            const data = await response.json();
            if (data.success) {
                const imageUrl = data.data.url;
                displayImageLink(imageUrl);
            } else {
                console.error('Image upload failed:', data.error);
            }
        } catch (error) {
            console.error('Error uploading image:', error);
        }
    }

    function displayImageLink(imageUrl) {
        const linkElement = document.createElement('a');
        linkElement.href = imageUrl;
        linkElement.textContent = imageUrl;
        linkElement.target = '_blank';

        const imageElement = document.createElement('img');
        imageElement.src = imageUrl;
        imageElement.alt = 'Uploaded Image';
        imageElement.style.maxWidth = '100%';
        imageElement.style.marginTop = '10px';

        imageLinkContainer.innerHTML = '';
        imageLinkContainer.appendChild(linkElement);
        imageLinkContainer.appendChild(document.createElement('br'));
        imageLinkContainer.appendChild(imageElement);
    }
});
