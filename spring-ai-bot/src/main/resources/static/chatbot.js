// chatbot.js
const chatContainer = document.querySelector('.chat-container');

// adjust width based on screen size
window.addEventListener('resize', () => {
  const screenWidth = window.innerWidth;
  if (screenWidth < 768) {
    chatContainer.style.width = '200px';
  } else if (screenWidth > 1200) {
    chatContainer.style.width = '700px';
  } else {
    chatContainer.style.width = '300px';
  }
});
document.getElementById('attachBtn').addEventListener('click', function() {
        document.getElementById('pdfUpload').click();
    });

    document.getElementById('pdfUpload').addEventListener('change', function(event) {
    console.log('Files selected:', event.target.files.length);
        const file = event.target.files[0];
        if (file) {
        const modal = document.getElementById('jobDescriptionModal');
        modal.style.display = 'block'; // Show the modal
         document.getElementById('submitJobDescription').addEventListener('click', function() {

           scoreATS();
           modal.style.display = 'none'; // Hide the modal
          });
        displayUserMessage('Find ATS score for my resume :' + document.getElementById("pdfUpload").files[0].name);

           // document.getElementById('sendMessage').innerHTML = "Score";
           // document.getElementById('sendMessage').dataset.mode = "score";  // Change mode
        }
    });


const button = document.getElementById('sendMessage');
document.addEventListener("keydown", (e) => {
    if (e.key === 'Enter') {
        button.click();
      }
});

    document.getElementById('sendMessage').addEventListener('click', function() {
        const mode = document.getElementById('sendMessage').dataset.mode;

        if (mode === "score") {
        displayUserMessage('Find ATS score for my resume :' + document.getElementById("pdfUpload").files[0].name);
            scoreATS();  // Call ATS Scoring API
        } else {
        var userInput = document.getElementById("messageInput").value;
            if (userInput.trim() !== "") {
            displayUserMessage(userInput);
            startChat(userInput); // Normal chat function
        }
    }});

/*document.getElementById("sendMessage").addEventListener("click", function() {
    var userInput = document.getElementById("userInput").value;
    if (userInput.trim() !== "") {
        displayUserMessage(userInput);
        //sendToAI(userInput);
        startChat(userInput);
    }
});
*/


function displayUserMessage(message) {
    const chatBox = document.getElementById("chatBox");
    const userMessage = document.createElement("div");
    userMessage.classList.add("message", "user");
    userMessage.innerText = message;
    chatBox.appendChild(userMessage);
    document.getElementById("messageInput").value = ""; // Clear input field
    chatBox.scrollTop = chatBox.scrollHeight; // Scroll to bottom
}

function displayAIMessage(message) {
    const chatBox = document.getElementById("chatBox");
    const aiMessage = document.createElement("div");
    aiMessage.classList.add("message", "ai");
    aiMessage.innerText = message;
    chatBox.appendChild(aiMessage);
    chatBox.scrollTop = chatBox.scrollHeight; // Scroll to bottom
}

function displayAIMessageStream(message) {
    const chatBox = document.getElementById("chatBox");

    const lastChild = chatBox.lastChild;
    if (lastChild && lastChild.classList.contains("ai")) {
        lastChild.innerText = lastChild.innerText + message;
        //console.log('lastChild now changed:: ', lastChild);
        chatBox.scrollTop = chatBox.scrollHeight;
    } else {
        const aiMessage = document.createElement("div");
        aiMessage.classList.add("message", "ai");
        aiMessage.innerText = message;
        console.log('aiMessage added new:: ', aiMessage);
        chatBox.appendChild(aiMessage);
        chatBox.scrollTop = chatBox.scrollHeight;
    }

     // Scroll to bottom
}

function sendToAI(userMessage) {
    fetch('/chatai/ask', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ message: userMessage })
    })
    .then(response => response.json())
    .then(data => {
        displayAIMessage(data.response.trim());
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

async function startChat(userMessage) {
     const response = await fetch('/chatai/askStream', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ message: userMessage })
        })
         const reader = response.body.getReader();
         const decoder = new TextDecoder();

                     while (true) {
                         const { value, done } = await reader.read();
                         if (done) break;
                         //console.log('value::',value);
                         const msg = decoder.decode(value).split(':').pop().trim();
                         //console.log('decode msg::',msg);
                         if(msg==="<think>" || msg==="</think>" || msg === "") continue;
                         console.log('decode msg::',msg);
                         displayAIMessageStream( msg + ' ');
                     }

        }

function scoreATS()  {
    console.log('scoreATS called ,number of files:'+document.getElementById("pdfUpload").files.length);
    var file = document.getElementById("pdfUpload").files[0];
     var jobDescription = document.getElementById('jobDescriptionInput').value;
    if (file) {
        var formData = new FormData();
        formData.append("file", file);
        formData.append("jobDescription", jobDescription);
        fetch("/chatai/upload", {
            method: "POST",
            body: formData
        })
        .then(response => response.text())
        .then(data => {
            console.log("data received");
           displayAIMessage(data.trim());
        })
        .catch(error => {
            console.error("Error:", error);
        });
        //document.getElementById('sendMessage').innerHTML = "SEND";
       // document.getElementById('sendMessage').dataset.mode = "send";
    }
}

