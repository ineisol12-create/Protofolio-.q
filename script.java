// Wait until the HTML document is fully loaded
document.addEventListener("DOMContentLoaded", () => {
    
    // 1. Hover Effect: Make stickers and notes "lift up" when hovered
    const interactiveItems = document.querySelectorAll('.sticky-note, .polaroid, .contact-envelope, .torn-tag');
    
    interactiveItems.forEach(item => {
        // Save the original CSS rotation so we don't lose it
        const originalTransform = window.getComputedStyle(item).transform;

        item.addEventListener('mouseenter', () => {
            // Scale up slightly and add a stronger shadow to create a "lifting" illusion
            item.style.transform = `${originalTransform} scale(1.03)`;
            item.style.boxShadow = "10px 15px 25px rgba(0,0,0,0.25)";
            item.style.zIndex = "10";
            item.style.transition = "transform 0.2s ease, box-shadow 0.2s ease";
        });

        item.addEventListener('mouseleave', () => {
            // Return back to its exact original placement
            item.style.transform = originalTransform;
            item.style.boxShadow = "";
            item.style.zIndex = "";
        });
    });

    // 2. Click Effect: Make the profile picture shake or tilt slightly when clicked
    const profilePhoto = document.querySelector('.main-photo');
    if (profilePhoto) {
        profilePhoto.addEventListener('click', () => {
            profilePhoto.style.transform = "rotate(3deg) scale(0.98)";
            setTimeout(() => {
                profilePhoto.style.transform = "";
            }, 150);
        });
    }

    // 3. Software Badge Wiggle: Make software icons tilt dynamically
    const softwareIcons = document.querySelectorAll('.sw-icon');
    softwareIcons.forEach((icon, index) => {
        icon.addEventListener('mouseenter', () => {
            // Alternate tilt direction based on even/odd icons
            const tiltAngle = index % 2 === 0 ? 8 : -8;
            icon.style.transform = `rotate(${tiltAngle}deg) scale(1.1)`;
            icon.style.transition = "transform 0.15s ease";
        });
        icon.style.cursor = "pointer";

        icon.addEventListener('mouseleave', () => {
            icon.style.transform = "none";
        });
    });
});

