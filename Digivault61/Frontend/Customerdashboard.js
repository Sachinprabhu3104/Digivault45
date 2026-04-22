document.addEventListener("DOMContentLoaded", function () {
    // Sidebar Toggle
    const hamburger = document.getElementById("hamburger");
    const sidebar = document.getElementById("sidebar");
    const mainContent = document.querySelector(".main-content");
    const openIcon = document.getElementById("openIcon");
    const closeSidebarBtn = document.getElementById("closeSidebarBtn");

    hamburger.addEventListener("click", () => {
        sidebar.classList.add("active");
        mainContent.classList.add("shifted");
        openIcon.style.display = "none";
        closeSidebarBtn.style.display = "block";
    });

    closeSidebarBtn.addEventListener("click", () => {
        sidebar.classList.remove("active");
        mainContent.classList.remove("shifted");
        openIcon.style.display = "block";
        closeSidebarBtn.style.display = "none";
    });

    // Profile Picture Upload
    const profilePicInput = document.getElementById("profile-pic-upload");
    const profilePicImg = document.getElementById("profile-pic-img");

    profilePicInput.addEventListener("change", function (event) {
        const file = event.target.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = (e) => profilePicImg.src = e.target.result;
            reader.readAsDataURL(file);
        }
    });

    // Logout Popup
    const logoutBtn = document.getElementById("logoutBtn");
    const logoutPopup = document.getElementById("logoutPopup");
    const confirmLogout = document.getElementById("confirmLogout");
    const cancelLogout = document.getElementById("cancelLogout");

    logoutBtn.addEventListener("click", () => logoutPopup.classList.add("show"));
    confirmLogout.addEventListener("click", () => window.location.href = "index.html");
    cancelLogout.addEventListener("click", () => logoutPopup.classList.remove("show"));

    document.querySelector(".popup-content").addEventListener("click", (e) => e.stopPropagation());
    logoutPopup.addEventListener("click", () => logoutPopup.classList.remove("show"));

    // Debit Card on Page Load
    const storedUserId = sessionStorage.getItem("userId") || localStorage.getItem("userId");

    if (storedUserId) {
        fetch(`http://localhost:8080/api/v1/virtualCard/${storedUserId}`)
            .then(response => response.json())
            .then(data => {
                if (data.cardNumber) {
                    displayCard(data);
                    document.getElementById("createCreditCard").disabled = false;
                } else {
                    document.getElementById("createCreditCard").disabled = true;
                }
            })
            .catch(error => console.error("Error fetching card:", error));
    }

    // View Debit Card Click
    document.getElementById("viewDebitCard").addEventListener("click", function () {
        const apiData = sessionStorage.getItem("apiData");
        const parsedData = JSON.parse(apiData || "[]");

        const userId = parsedData.length ? parsedData[0].userId : storedUserId;

        if (!userId) {
            alert("User ID is missing. Please log in again.");
            return;
        }

        fetch(`http://localhost:8080/api/v1/virtualCard/${userId}`)
            .then(response => response.json())
            .then(data => {
                if (data.cardNumber) {
                    displayCard(data);
                } else {
                    generateVirtualCard(userId);
                }
            })
            .catch(error => {
                console.error("Error fetching card:", error);
                alert("Failed to fetch virtual card. Try again later.");
            });
    });

    function displayCard(data) {
        const maskedNumber = data.cardNumber.replace(/\d{12}(\d{4})/, "**** **** **** $1");
        document.getElementById("cardsContainer").innerHTML = `
            <div class="bank-card debit">
                <div class="bank-name">My Bank</div>
                <div class="card-number">${maskedNumber}</div>
                <div class="expiry-date"><strong>Expiry:</strong> ${data.expiryDate}</div>
                <div class="cvv-section">
                <label for="cvv"><strong>CVV:</strong></label>
                <input type="password" id="cvv" value="${data.cvv}" readonly />
                <span id="cvvToggleBtn" class="eye-icon">👁️</span>
            </div>
                <button onclick="manageCard()">Manage Card</button>
            </div>
        `;
        document.querySelector("#cvvToggleBtn").addEventListener("click", toggleCVV);
    }

    function toggleCVV() {
    const cvvField = document.getElementById("cvv");
    if (cvvField.type === "password") {
        cvvField.type = "text";
    } else {
        cvvField.type = "password";
    }
}

    function generateVirtualCard(userId) {
        fetch("http://localhost:8080/api/v1/generateVirtualCard", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ userId: parseInt(userId) })
        })
            .then(response => response.json())
            .then(data => {
                if (data.status === "success") {
                    alert(data.message);
                    displayCard(data.cardDetails);
                    document.getElementById("createCreditCard").disabled = false;
                } else {
                    alert(data.message);
                }
            })
            .catch(error => {
                console.error("Error generating card:", error);
                alert("Something went wrong.");
            });
    }

    // Manage Card Popup
    window.manageCard = function () {
        document.getElementById("manageCardPopup").classList.add("show");
    };

    document.getElementById("closePopupBtn").addEventListener("click", () => {
        document.getElementById("manageCardPopup").classList.remove("show");
    });

    // Popup Button Functionality
    function attachPopupEventListeners() {
        const blockCardBtn = document.getElementById("blockCardBtn");
        const manageUsageBtn = document.getElementById("manageUsageBtn");
        const viewSummaryBtn = document.getElementById("viewSummaryBtn");

        if (blockCardBtn) blockCardBtn.onclick = () => alert("Card has been blocked/unblocked successfully!");
        if (manageUsageBtn) manageUsageBtn.onclick = () => alert("Manage your card usage settings.");
        if (viewSummaryBtn) viewSummaryBtn.onclick = () => alert("Card Status: Active\nMax ATM Limit: ₹50,000\nLinked Account No: 1234567890\nMax Purchase Limit: ₹1,00,000");
    }

    attachPopupEventListeners();

    // Account Summary
    const accountSummaryPopup = document.getElementById("accountSummaryPopup");
    const closeAccountSummary = document.getElementById("closeAccountSummary");
    const accountSummaryLink = document.getElementById("accountSummaryLink");

    accountSummaryLink.addEventListener("click", () => {
        accountSummaryPopup.style.display = "block";
    });

    closeAccountSummary.addEventListener("click", () => {
        accountSummaryPopup.style.display = "none";
    });

    window.addEventListener("click", (event) => {
        if (event.target === accountSummaryPopup) {
            accountSummaryPopup.style.display = "none";
        }
    });

    

    // Dark Mode Toggle
    const darkModeToggle = document.getElementById("darkModeToggle");

    function applyDarkMode() {
        document.body.classList.add("dark-mode");
        darkModeToggle.innerHTML = '<i class="fas fa-sun"></i> Light Mode';
        localStorage.setItem("theme", "dark");
    }

    function removeDarkMode() {
        document.body.classList.remove("dark-mode");
        darkModeToggle.innerHTML = '<i class="fas fa-moon"></i> Dark Mode';
        localStorage.setItem("theme", "light");
    }

    if (localStorage.getItem("theme") === "dark") {
        applyDarkMode();
    }

    darkModeToggle.addEventListener("click", () => {
        if (document.body.classList.contains("dark-mode")) {
            removeDarkMode();
        } else {
            applyDarkMode();
        }
    });

    // Settings Submenu Toggle
    const settingsSubmenu = document.getElementById("settings-submenu");
    window.toggleSettingsMenu = function () {
        settingsSubmenu.style.display = settingsSubmenu.style.display === "block" ? "none" : "block";
    };
});


