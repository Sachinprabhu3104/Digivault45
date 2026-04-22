async function fetchUsers() {
    const user = {
        firstName: document.getElementById("First_name").value,
        lastName: document.getElementById("Last_name").value,
        email: document.getElementById("Email_id").value,
        password: document.getElementById("Password").value,
        mobileNo: document.getElementById("mobile_no").value,
        gender: document.getElementById("Gender").value,
        address: document.getElementById("Address").value
    };

    try {
        const response = await fetch("http://localhost:8080/api/v1/fetchUsers", {
            method: 'GET',
            mode: 'cors',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user)
        });

        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }

        const data = await response.json();
        console.log("User registered successfully:", data);
        alert("Registration successful!");
    } catch (error) {
        console.error("Error during registration:", error);
        alert("Failed to register. Check console for details.");
    }
}

// Get popup elements
const forgotPasswordPopup = document.getElementById("forgotPasswordPopup");
const verificationPopup = document.getElementById("verificationPopup");
const confirmationPopup = document.getElementById("confirmationPopup");

// Function to open Forgot Password Popup
function openForgotPopup() {
    forgotPasswordPopup.classList.remove("hidden");
}

// Function to close Forgot Password Popup
function closeForgotPopup() {
    forgotPasswordPopup.classList.add("hidden");
}

// Function to show verification step
function nextStep() {
    const userEmail = document.getElementById("forgotEmail").value.trim();

    if (userEmail === "") {
        alert("Please enter your registered Email ID.");
        return;
    }

    if (!validateEmail(userEmail)) {
        alert("Please enter a valid Email ID.");
        return;
    }

    // Hide first popup and show verification step
    forgotPasswordPopup.classList.add("hidden");
    verificationPopup.classList.remove("hidden");
}

// Function to close Verification Popup
function closeVerificationPopup() {
    verificationPopup.classList.add("hidden");
}

// Function to send password reset and show confirmation popup
function sendPasswordReset() {
    const mobileValue = document.getElementById("forgotMobile").value.trim();
    const emailValue = document.getElementById("verifyEmail").value.trim();

    if (mobileValue === "" || emailValue === "") {
        alert("Please enter both Mobile Number and Email ID.");
        return;
    }

    if (!validateEmail(emailValue)) {
        alert("Please enter a valid Email ID.");
        return;
    }

    // Hide verification popup and show confirmation popup
    verificationPopup.classList.add("hidden");
    confirmationPopup.classList.remove("hidden");
}

// Function to close Confirmation Popup
function closeConfirmationPopup() {
    confirmationPopup.classList.add("hidden");
}

// Function to validate email format
function validateEmail(email) {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
}


function nextStep() {
    document.getElementById("verificationPopup").style.display = "block";
}
function togglePassword() {
    const passwordInput = document.getElementById("password");
    const currentType = passwordInput.getAttribute("type");
    passwordInput.setAttribute("type", currentType === "password" ? "text" : "password");
}
