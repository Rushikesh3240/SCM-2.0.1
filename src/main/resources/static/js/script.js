console.log("Script Loaded");

let currentTheme = getTheme();
applyTheme(currentTheme);

const changeThemeButton = document.querySelector('#theme_change_button');
const themeIcon = changeThemeButton.querySelector("i");
const themeLabel = changeThemeButton.querySelector("span");

// set initial label + icon
updateButton(currentTheme);

changeThemeButton.addEventListener('click', () => {
  console.log("change theme button clicked");

  currentTheme = currentTheme === "dark" ? "light" : "dark";
  setTheme(currentTheme);
  applyTheme(currentTheme);
  updateButton(currentTheme);
});

function applyTheme(theme) {
  const html = document.querySelector('html');
  if (theme === "dark") {
    html.classList.add("dark");
  } else {
    html.classList.remove("dark");
  }
}

function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

function getTheme() {
  return localStorage.getItem("theme") || "light";
}

function updateButton(theme) {
  if (theme === "dark") {
    themeIcon.className = "fa-solid fa-moon";
    themeLabel.textContent = "Dark";
  } else {
    themeIcon.className = "fa-solid fa-sun";
    themeLabel.textContent = "Light";
  }
}
