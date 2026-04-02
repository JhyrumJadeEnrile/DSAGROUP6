let currentSpeed = 1;
let isMuted = false;

function getVideo() {
    return document.getElementById('mainVideo');
}

function togglePlayPause() {
    const video = getVideo();
    const icon = document.getElementById('playPauseIcon');
    
    if (video.paused) {
        video.play();
        icon.textContent = '⏸';
    } else {
        video.pause();
        icon.textContent = '▶';
    }
}

function restartVideo() {
    const video = getVideo();
    video.currentTime = 0;
    video.play();
    document.getElementById('playPauseIcon').textContent = '⏸';
    showNotification('🔄 Video Restarted');
}

function adjustSpeed() {
    const video = getVideo();
    const speeds = [0.5, 0.75, 1, 1.25, 1.5, 2];
    let currentIndex = speeds.indexOf(currentSpeed);
    currentIndex = (currentIndex + 1) % speeds.length;
    currentSpeed = speeds[currentIndex];
    
    video.playbackRate = currentSpeed;
    document.getElementById('speedText').textContent = `⚡ ${currentSpeed}x`;
    showNotification(`Speed: ${currentSpeed}x`);
}

function toggleFullscreen() {
    const video = getVideo();
    
    if (document.fullscreenElement) {
        exitFullscreen();
    } else {
        enterFullscreen(video);
    }
}

function enterFullscreen(element) {
    if (element.requestFullscreen) {
        element.requestFullscreen();
    } else if (element.webkitRequestFullscreen) {
        element.webkitRequestFullscreen();
    } else if (element.mozRequestFullScreen) {
        element.mozRequestFullScreen();
    } else if (element.msRequestFullscreen) {
        element.msRequestFullscreen();
    }
}

function exitFullscreen() {
    if (document.exitFullscreen) {
        document.exitFullscreen();
    } else if (document.webkitExitFullscreen) {
        document.webkitExitFullscreen();
    } else if (document.mozCancelFullScreen) {
        document.mozCancelFullScreen();
    } else if (document.msExitFullscreen) {
        document.msExitFullscreen();
    }
}

function toggleMute() {
    const video = getVideo();
    const icon = document.getElementById('muteIcon');
    
    video.muted = !video.muted;
    isMuted = video.muted;
    
    if (isMuted) {
        icon.textContent = '🔇';
        showNotification('🔇 Muted');
    } else {
        icon.textContent = '🔊';
        showNotification('🔊 Unmuted');
    }
}

function toggleMobileMenu() {
    const mobileNav = document.getElementById('mobileNav');
    mobileNav.classList.toggle('active');
}

function showNotification(message) {
    const existing = document.querySelector('.notification');
    if (existing) {
        existing.remove();
    }
    
    const notification = document.createElement('div');
    notification.className = 'notification';
    notification.textContent = message;
    
    document.body.appendChild(notification);
    
    setTimeout(() => {
        notification.classList.add('fadeOut');
        setTimeout(() => notification.remove(), 300);
    }, 2000);
}

document.addEventListener('DOMContentLoaded', function() {
    const video = getVideo();
    
    if (video) {
        video.volume = 0.7;
        
        video.addEventListener('play', function() {
            document.getElementById('playPauseIcon').textContent = '⏸';
        });
        
        video.addEventListener('pause', function() {
            document.getElementById('playPauseIcon').textContent = '▶';
        });
        
        document.addEventListener('keydown', function(e) {
            if (e.target.tagName === 'INPUT' || e.target.tagName === 'TEXTAREA') {
                return;
            }
            
            switch(e.key.toLowerCase()) {
                case ' ':
                    e.preventDefault();
                    togglePlayPause();
                    break;
                    
                case 'f':
                    e.preventDefault();
                    toggleFullscreen();
                    break;
                    
                case 'r':
                    e.preventDefault();
                    restartVideo();
                    break;
                    
                case 's':
                    e.preventDefault();
                    adjustSpeed();
                    break;
                    
                case 'm':
                    e.preventDefault();
                    toggleMute();
                    break;
                    
                case 'arrowleft':
                    e.preventDefault();
                    video.currentTime = Math.max(0, video.currentTime - 5);
                    showNotification('⏪ -5s');
                    break;
                    
                case 'arrowright':
                    e.preventDefault();
                    video.currentTime = Math.min(video.duration, video.currentTime + 5);
                    showNotification('⏩ +5s');
                    break;
            }
        });
        
        document.addEventListener('click', function(e) {
            const mobileNav = document.getElementById('mobileNav');
            const toggle = document.querySelector('.mobile-menu-toggle');
            
            if (mobileNav.classList.contains('active') && 
                !mobileNav.contains(e.target) && 
                !toggle.contains(e.target)) {
                mobileNav.classList.remove('active');
            }
        });
    }
});

const style = document.createElement('style');
style.textContent = `
    .notification {
        position: fixed;
        top: 90px;
        right: 20px;
        background: var(--accent);
        color: var(--bg);
        padding: 15px 25px;
        border-radius: 10px;
        font-weight: bold;
        z-index: 2000;
        animation: slideIn 0.3s ease;
        box-shadow: 0 5px 20px rgba(56, 189, 248, 0.5);
        font-size: 16px;
    }
    
    .notification.fadeOut {
        animation: slideOut 0.3s ease forwards;
    }
    
    @keyframes slideIn {
        from {
            transform: translateX(400px);
            opacity: 0;
        }
        to {
            transform: translateX(0);
            opacity: 1;
        }
    }
    
    @keyframes slideOut {
        from {
            transform: translateX(0);
            opacity: 1;
        }
        to {
            transform: translateX(400px);
            opacity: 0;
        }
    }
    
    @media (max-width: 768px) {
        .notification {
            top: 70px;
            right: 10px;
            left: 10px;
            text-align: center;
        }
    }
`;
document.head.appendChild(style);