// home.ts - Enhanced animation controller for woman image
document.addEventListener('DOMContentLoaded', () => {
    // Get the woman container element
    const womanContainer = document.getElementById('woman-container') as HTMLElement;
    
    if (womanContainer) {
        // Variable to track if CSS animation is enabled
        let cssAnimationEnabled = true;
        
        // Additional vertical animation parameters
        let verticalPosition = 0;
        let verticalDirection = 1; // 1 for up, -1 for down
        let animationSpeed = 0.3; // Speed of the vertical animation
        
        // Function to combine CSS horizontal and JS vertical animations
        const animateWomanVertically = (): void => {
            // Change vertical position based on direction
            verticalPosition += animationSpeed * verticalDirection;
            
            // Reverse direction when reaching limits
            if (verticalPosition > 15) { // Maximum up movement (15px)
                verticalDirection = -1;
            } else if (verticalPosition < 0) { // Minimum down movement (0px)
                verticalDirection = 1;
            }
            
            // Get current transform and add vertical movement
            const currentTransform = window.getComputedStyle(womanContainer).transform;
            
            // Apply the vertical movement while preserving other transforms
            if (window.innerWidth <= 600) {
                // For mobile - CSS already centers with translateX(-50%)
                womanContainer.style.transform = `translateX(-50%) translateY(${verticalPosition}px)`;
            } else {
                // For desktop - CSS handles horizontal movement, we add vertical
                // Use translateY to add our vertical animation without disrupting CSS animation
                womanContainer.style.transform = `translateY(${verticalPosition}px)`;
            }
            
            // Continue the animation
            requestAnimationFrame(animateWomanVertically);
        };
        
        // Start the vertical animation
        animateWomanVertically();
        
        // Pause/resume animations on hover
        womanContainer.addEventListener('mouseenter', () => {
            // Pause our vertical animation
            animationSpeed = 0;
            
            // Pause the CSS animation
            if (cssAnimationEnabled && window.innerWidth > 600) {
                womanContainer.style.animationPlayState = 'paused';
            }
        });
        
        womanContainer.addEventListener('mouseleave', () => {
            // Resume our vertical animation
            animationSpeed = 0.3;
            
            // Resume CSS animation
            if (cssAnimationEnabled && window.innerWidth > 600) {
                womanContainer.style.animationPlayState = 'running';
            }
        });
        
        // Handle responsive behavior
        const handleResize = (): void => {
            // Check if we need to manage CSS animation or not
            if (window.innerWidth <= 600) {
                // On mobile, CSS has animation: none; so we don't need to manage it
                cssAnimationEnabled = false;
                // Reset any animation state for clean mobile presentation
                womanContainer.style.animationPlayState = '';
            } else {
                // On desktop, CSS has animation enabled
                cssAnimationEnabled = true;
            }
        };
        
        // Initial call and listen for window resize
        window.addEventListener('resize', handleResize);
        handleResize();
    }
});