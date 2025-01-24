// Toggle between Sign Up and Sign In pages
document.getElementById('signin-link').addEventListener('click', function () {
    document.getElementById('signup-container').style.display = 'none';
    document.getElementById('signin-container').style.display = 'block';
});

document.getElementById('signup-link').addEventListener('click', function () {
    document.getElementById('signin-container').style.display = 'none';
    document.getElementById('signup-container').style.display = 'block';
});

// Sign Up
document.getElementById('signup-form').addEventListener('submit', async function (event) {
    event.preventDefault();
    const username = document.getElementById('username').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    const response = await fetch('http://localhost:8080/api/signup', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, email, password })
    });

    if (response.status === 201) {
        alert('Registration successful! Redirecting to Sign In.');
        document.getElementById('signup-container').style.display = 'none';
        document.getElementById('signin-container').style.display = 'block';
    } else {
        const error = await response.text();
        alert(error);
    }
});

// Sign In
document.getElementById('signin-form').addEventListener('submit', async function (event) {
    event.preventDefault();
    const email = document.getElementById('signin-email').value;
    const password = document.getElementById('signin-password').value;

    const response = await fetch(`http://localhost:8080/api/signin?email=${email}&password=${password}`, {
        method: 'POST'
    });

    if (response.ok) {
        alert('Sign In Successful!');
        window.location.href = 'index1.html';
    } else {
        alert('Invalid credentials!');
    }
});
