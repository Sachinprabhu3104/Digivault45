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
