document.addEventListener("DOMContentLoaded", function () {
    const chatbotBox = document.getElementById("chatbot-box");
    const chatBody = document.getElementById("chat-body");
    const inputField = document.getElementById("user-input");
    const sendBtn = document.getElementById("send-btn");
    const chatToggleBtn = document.getElementById("chat-toggle-btn"); // Ensure this ID exists on your button

    // Toggle chatbot visibility when clicking "Chat with Us"
    chatToggleBtn.addEventListener("click", toggleChatbot);

    function toggleChatbot() {
        chatbotBox.style.display = chatbotBox.style.display === "block" ? "none" : "block";
    }

    // Send message when clicking button or pressing Enter
    sendBtn.addEventListener("click", sendMessage);
    inputField.addEventListener("keypress", function (event) {
        if (event.key === "Enter") sendMessage();
    });

    async function sendMessage() {
        let userMessage = inputField.value.trim();
        if (userMessage === "") return;

        displayMessage(userMessage, "user");
        inputField.value = "";

        try {
            const response = await fetch(`http://localhost:8080/api/v1/chatbot?message=${encodeURIComponent(userMessage)}`);
            const data = await response.json();
            displayMessage(data.response, "bot");
        } catch (error) {
            console.error("Error fetching chatbot response:", error);
            displayMessage("⚠️ Sorry, I couldn't fetch a response.", "bot");
        }
    }

    function displayMessage(message, sender) {
        const messageClass = sender === "user" ? "user-message" : "bot-message";
        chatBody.innerHTML += `<div class="${messageClass}">${sender === "user" ? "👤" : "🤖"} ${message}</div>`;
        chatBody.scrollTop = chatBody.scrollHeight;
    }
});
