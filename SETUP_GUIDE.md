# 🚀 COMPLETE SETUP GUIDE - DSA VISUALIZER

## ✅ PROJECT STRUCTURE (VERIFIED)

```
websitedsa-fixed-final/
├── pom.xml
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── websitedsa/
│       │               └── WebsiteDSAApplication.java
│       └── resources/
│           ├── application.properties
│           ├── templates/
│           │   └── index.html           ← ONLY ONE HTML FILE
│           └── static/
│               ├── css/
│               │   └── style.css
│               ├── js/
│               │   └── script.js
│               └── videos/
│                   ├── Stack.mp4
│                   ├── Queue.mp4
│                   ├── Singly_Linked_List.mp4
│                   ├── Doubly_Linked_List.mp4
│                   ├── Singly_Circular_Linked_List.mp4
│                   ├── MATRIX.mp4
│                   └── Dictionary_and_tuples.mp4
```

## 🔧 SETUP STEPS

### Step 1: Extract the Project
Extract `websitedsa-fixed-final` folder to your desired location.

### Step 2: Open in IDE (IntelliJ IDEA or Eclipse)
1. Open IntelliJ IDEA or Eclipse
2. File → Open → Select `websitedsa-fixed-final` folder
3. Wait for Maven to download dependencies

### Step 3: Run the Application

**Option A: From IDE**
1. Navigate to `WebsiteDSAApplication.java`
2. Right-click → Run

**Option B: From Terminal/Command Prompt**
```bash
cd websitedsa-fixed-final
mvn spring-boot:run
```

### Step 4: Access the Website
Open your browser and go to:
```
http://localhost:6969
```

## ✅ WHAT YOU SHOULD SEE

1. **Top Navigation Bar** with all data structures
2. **Stack video playing automatically** on the homepage
3. **Click any navigation item** to switch videos instantly
4. **Working controls**: Play/Pause, Restart, Speed, Fullscreen, Mute

## 📋 CHECKLIST - Verify These Work:

- [ ] Application starts without errors
- [ ] Homepage loads at http://localhost:6969
- [ ] Stack video plays automatically
- [ ] Top navigation shows all 7 data structures
- [ ] Clicking "Queue" switches to Queue video
- [ ] Clicking "Singly Linked List" switches to that video
- [ ] Play/Pause button works
- [ ] Restart button works
- [ ] Speed button cycles through speeds
- [ ] Fullscreen button works
- [ ] Mute button works
- [ ] Keyboard shortcuts work (Space, F, R, S, M)
- [ ] Mobile menu works (on small screens)

## 🎯 HOW IT WORKS

### Single Page Application
- Only **ONE** HTML file: `index.html`
- All routes use the same template
- Videos switch without page reload

### Routes
- `/` → Shows Stack video (default)
- `/ds/stack` → Shows Stack video
- `/ds/queue` → Shows Queue video
- `/ds/singly-linked-list` → Shows Singly Linked List video
- And so on...

### File Locations
- **Java Code**: `src/main/java/com/example/websitedsa/`
- **HTML Template**: `src/main/resources/templates/index.html`
- **CSS**: `src/main/resources/static/css/style.css`
- **JavaScript**: `src/main/resources/static/js/script.js`
- **Videos**: `src/main/resources/static/videos/`

## 🐛 TROUBLESHOOTING

### Error: "Whitelabel Error Page"
**Cause**: Template file not found
**Fix**: Verify `index.html` exists in `src/main/resources/templates/`

### Error: "Port 6969 already in use"
**Fix**: Change port in `application.properties`:
```properties
server.port=8080
```

### Videos don't play
**Fix**: Verify video files are in `src/main/resources/static/videos/`

### CSS not loading
**Fix**: Verify `style.css` is in `src/main/resources/static/css/`

### JavaScript not working
**Fix**: Verify `script.js` is in `src/main/resources/static/js/`

## 💻 KEYBOARD SHORTCUTS

- **Space** - Play/Pause video
- **F** - Toggle fullscreen
- **R** - Restart video
- **S** - Cycle playback speed
- **M** - Toggle mute
- **←** - Rewind 5 seconds
- **→** - Forward 5 seconds

## 📱 MOBILE SUPPORT

- Responsive design
- Hamburger menu for navigation
- Touch-friendly controls
- Works on tablets and phones

## 🎨 CUSTOMIZATION

### Change Colors
Edit `src/main/resources/static/css/style.css`:
```css
:root {
    --bg: #0f172a;          /* Background */
    --card: #1e293b;        /* Cards */
    --accent: #38bdf8;      /* Accent color */
    --text: #f8fafc;        /* Text */
}
```

### Change Port
Edit `src/main/resources/application.properties`:
```properties
server.port=YOUR_PORT
```

### Add More Data Structures
Edit `WebsiteDSAApplication.java`:
```java
videos.put("your-ds-name", new VideoInfo(
    "Display Name", 
    "filename.mp4", 
    "Description", 
    "📊"  // Icon
));
```

## ✅ FINAL CHECKLIST

Before reporting issues, verify:
1. ✅ Java 17 or higher installed
2. ✅ Maven is installed (or use `mvnw`)
3. ✅ All files are in correct directories
4. ✅ Videos are in `static/videos/` folder
5. ✅ Port 6969 is not in use
6. ✅ No firewall blocking port 6969

## 🎉 SUCCESS!

If you see the Stack video playing with the navigation bar, 
**CONGRATULATIONS!** Your DSA Visualizer is working perfectly!

---

For any issues, check:
1. Console logs in terminal
2. Browser console (F12)
3. File locations match structure above
