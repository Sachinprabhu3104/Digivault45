// Utility function to open modals
function openModal(modalId) {
  const modal = document.getElementById(modalId);
  if (modal) {
    modal.style.display = 'flex';
  } else {
    console.error(`Modal with ID '${modalId}' not found.`);
  }
}

// Utility function to close modals
function closeModal(modalId) {
  const modal = document.getElementById(modalId);
  if (modal) {
    modal.style.display = 'none';
  } else {
    console.error(`Modal with ID '${modalId}' not found.`);
  }
}

// Display specific modals
function displayModal(modalType) {
  const modals = {
    userOverview: 'userview-modal',
    accounts: 'accounts-modal',
    transactionsOverview: 'transactions-modal',
  };
  const modalId = modals[modalType];
  if (modalId) {
    openModal(modalId);
  } else {
    console.error(`Modal type '${modalType}' not recognized.`);
  }
}

// Password Change Submission
function handlePasswordChange(event) {
  event.preventDefault();
  const userId = document.getElementById('change-user-id')?.value.trim();
  const newPassword = document.getElementById('new-password')?.value.trim();

  if (userId && newPassword) {
    alert(`Password for User ID: ${userId} has been successfully changed.`);
    closeModal('change-password-modal');
  } else {
    alert("Please fill in all fields.");
  }
}

// Unlock User Submission
function handleUnlockUser(event) {
  event.preventDefault();
  const userId = document.getElementById('unlock-user-id')?.value.trim();

  if (userId) {
    alert(`User ID: ${userId} has been successfully unlocked.`);
    closeModal('unlock-user-modal');
  } else {
    alert("Please enter a User ID.");
  }
}

// Block User Submission
function handleBlockUser(event) {
  event.preventDefault();
  const userId = document.getElementById('block-user-id')?.value.trim();

  if (userId) {
    alert(`User ID: ${userId} has been successfully blocked.`);
    closeModal('block-user-modal');
  } else {
    alert("Please enter a User ID.");
  }
}

// Open Modal
function openModal(id) {
  document.getElementById(id).style.display = 'block';
}

// Close Modal
function closeModal(id) {
  document.getElementById(id).style.display = 'none';
}

// Submit Change Password Form
function submitChangePassword(event) {
  event.preventDefault();

  const userId = document.getElementById('userId').value;
  const newPassword = document.getElementById('newPassword').value;

  fetch('/api/v1/users/change-password', {
      method: 'PUT',
      headers: {
          'Content-Type': 'application/json'
      },
      body: JSON.stringify({ userId, newPassword })
  })
  .then(response => {
      if (!response.ok) {
          throw new Error("Password change failed");
      }
      return response.text(); // or response.json()
  })
  .then(data => {
      alert('Password changed successfully!');
      closeModal('change-password-modal');
  })
  .catch(error => {
      alert('Error: ' + error.message);
  });
}


// Get the modal and buttons
// const logoutModal = document.getElementById("logoutModal");
// const logoutBtn = document.getElementById("logoutBtn");
// const confirmLogoutBtn = document.getElementById("confirmLogout");
// const cancelLogoutBtn = document.getElementById("cancelLogout");

// // Show the logout confirmation modal when clicking the logout button
// logoutBtn.addEventListener("click", () => {
//   logoutModal.style.display = "flex";
// });

// // Close the modal when clicking "Cancel"
// cancelLogoutBtn.addEventListener("click", () => {
//   logoutModal.style.display = "none";
// });

// // Perform logout when clicking "Confirm Logout"
// confirmLogoutBtn.addEventListener("click", () => {
//   // Redirect to login page or clear session (modify as needed)
//   window.location.href = "index.html"; // Update with actual login page
// });

// // Close modal if user clicks outside the modal content
// window.addEventListener("click", (event) => {
//   if (event.target === logoutModal) {
//     logoutModal.style.display = "none";
//   }
// });


// // Attach event listeners for modals and forms
// document.addEventListener('DOMContentLoaded', () => {
//   // Form submission handlers
//   const forms = [
//     { modalId: 'change-password-modal', handler: handlePasswordChange },
//     { modalId: 'unlock-user-modal', handler: handleUnlockUser },
//     { modalId: 'block-user-modal', handler: handleBlockUser },
//   ];

//   forms.forEach(({ modalId, handler }) => {
//     const form = document.querySelector(`#${modalId} form`);
//     if (form) {
//       form.addEventListener('submit', handler);
//     }
//   });

//   // Close modal on clicking outside modal content
//   document.querySelectorAll('.modal').forEach((modal) => {
//     modal.addEventListener('click', (e) => {
//       if (e.target === modal) {
//         modal.style.display = 'none';
//       }
//     });
//   });
// });
