function loadContent(section) {
    const contentDiv = document.getElementById("dynamic-content");
    if (section === "contacts") {
      contentDiv.innerHTML = "<h2>Contacts</h2><p>This is the Contacts section.</p>";
    } else if (section === "dashboard") {
      contentDiv.innerHTML = "<h2>Dashboard</h2><p>This is the Dashboard section.</p>";
    } else if (section === "profile") {
      contentDiv.innerHTML = "<h2>Profile</h2><p>This is the Profile section.</p>";
    }
  }
  