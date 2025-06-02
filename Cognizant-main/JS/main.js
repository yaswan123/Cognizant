// JavaScript for Local Community Event Portal

// 1. JavaScript Basics & Setup
console.log("Welcome to the Community Portal");
window.onload = () => {
  alert("Page fully loaded!");
};

// 2. Syntax, Data Types, and Operators
const eventName = "Community Gathering";
const eventDate = "2025-06-15";
let availableSeats = 50;
console.log(`Event: ${eventName} on ${eventDate}. Seats available: ${availableSeats}`);

// 3. Conditionals, Loops, and Error Handling
const events = [
  { name: "Music Fest", date: "2025-06-20", seats: 100, category: "music" },
  { name: "Art Exhibition", date: "2025-05-10", seats: 0, category: "art" },
  { name: "Tech Talk", date: "2025-07-15", seats: 50, category: "tech" },
];

events.forEach((event) => {
  const eventDate = new Date(event.date);
  const today = new Date();
  if (eventDate >= today && event.seats > 0) {
    console.log(`Upcoming Event: ${event.name} on ${event.date}`);
  } else {
    console.log(`Event ${event.name} is either past or full.`);
  }
});

// 4. Functions, Scope, Closures, Higher-Order Functions
function addEvent(name, date, seats, category) {
  events.push({ name, date, seats, category });
}

function registerUser(eventName) {
  try {
    const event = events.find((e) => e.name === eventName);
    if (event && event.seats > 0) {
      event.seats--;
      console.log(`Registered for ${event.name}. Seats left: ${event.seats}`);
    } else {
      throw new Error("Event not available or full.");
    }
  } catch (err) {
    console.error(err.message);
  }
}

function filterEventsByCategory(category) {
  return events.filter((event) => event.category === category);
}

function registrationCounter() {
  let count = 0;
  return function () {
    count++;
    return count;
  };
}
const countRegistration = registrationCounter();

// 5. Objects and Prototypes
function Event(name, date, seats) {
  this.name = name;
  this.date = date;
  this.seats = seats;
}
Event.prototype.checkAvailability = function () {
  return this.seats > 0;
};

const eventObj = new Event("Food Carnival", "2025-08-01", 30);
console.log(Object.entries(eventObj));

// 6. Arrays and Methods
const eventList = [
  { name: "Marathon", category: "sports" },
  { name: "Book Fair", category: "literature" },
  { name: "Jazz Night", category: "music" },
];
eventList.push({ name: "Tech Expo", category: "tech" });

const musicEvents = eventList.filter((event) => event.category === "music");
const eventNames = eventList.map((event) => `Event: ${event.name}`);
console.log(eventNames);

// 7–8. DOM Manipulation & Event Handling
document.addEventListener("DOMContentLoaded", () => {
  const registrationForm = document.getElementById("registrationForm");
  const confirmationMessage = document.getElementById("confirmationMessage");
  const charCount = document.getElementById("charCount");

  // Textarea character counter
  const messageTextarea = document.getElementById("message");
  messageTextarea.addEventListener("input", () => {
    charCount.textContent = `${messageTextarea.value.length}/250`;
  });

  // 11. Working with Forms & 12. AJAX & Fetch API
  registrationForm.addEventListener("submit", (e) => {
    e.preventDefault();

    const name = registrationForm.name.value.trim();
    const email = registrationForm.email.value.trim();
    const phone = registrationForm.phone.value.trim();
    const eventDate = registrationForm.eventDate.value;
    const eventType = registrationForm.eventType.value;
    const message = registrationForm.message.value;

    if (!name || !email || !eventDate || !eventType) {
      confirmationMessage.textContent = "Please fill in all required fields.";
      confirmationMessage.style.color = "red";
      return;
    }

    const registrationData = {
      name,
      email,
      phone,
      eventDate,
      eventType,
      message,
    };

    confirmationMessage.style.color = "black";
    confirmationMessage.textContent = "Submitting registration...";

    // 12. AJAX & Fetch API with 9. Async/Await
    async function submitRegistration() {
      try {
        const response = await fetch("https://jsonplaceholder.typicode.com/posts", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(registrationData),
        });

        if (!response.ok) throw new Error("Submission failed");

        const result = await response.json();
        confirmationMessage.style.color = "green";
        confirmationMessage.textContent = "Registration successful!";
        console.log(result);
        registrationForm.reset();
        charCount.textContent = "0/250";
      } catch (error) {
        confirmationMessage.style.color = "red";
        confirmationMessage.textContent = "Error submitting form. Please try again.";
        console.error(error);
      }
    }

    // Simulate delay
    setTimeout(() => {
      submitRegistration();
    }, 1500);
  });

  // 8. Event Handling - Category filter and key search
  const filterInput = document.getElementById("eventType");
  const searchInput = document.getElementById("search");

  if (searchInput) {
    searchInput.addEventListener("keydown", (e) => {
      if (e.key === "Enter") {
        const keyword = searchInput.value.toLowerCase();
        const filtered = events.filter((ev) => ev.name.toLowerCase().includes(keyword));
        console.log("Search results:", filtered);
      }
    });
  }

  if (filterInput) {
    filterInput.addEventListener("change", () => {
      const selected = filterInput.value;
      const filtered = filterEventsByCategory(selected);
      console.log("Filtered by category:", filtered);
    });
  }
});

// 14. jQuery and JS Frameworks
// If jQuery is loaded:
if (window.jQuery) {
  $('#registerBtn').click(() => {
    $('#confirmationMessage').fadeIn().delay(1000).fadeOut();
  });
  // One benefit of frameworks like React: Component-based structure & reactive UI updates.
}
