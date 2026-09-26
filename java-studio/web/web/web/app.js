const editor = document.getElementById("codeEditor");
const consoleBox = document.getElementById("console");
const status = document.getElementById("status");
const saveStatus = document.getElementById("saveStatus");

document.getElementById("runBtn").addEventListener("click", () => {

    status.textContent = "Running...";

    consoleBox.textContent = "Compiling Main.java...\n";

    setTimeout(() => {

        consoleBox.textContent =
`Compiling Main.java...

Hello from Java Studio!

BUILD SUCCESS
Process finished successfully.`;

        status.textContent = "Success";

    }, 700);
});


document.getElementById("saveBtn").addEventListener("click", () => {

    localStorage.setItem(
        "javaStudioCode",
        editor.value
    );

    saveStatus.textContent = "Saved ✓";

    setTimeout(() => {
        saveStatus.textContent = "";
    }, 2000);
});


document.getElementById("clearBtn").addEventListener("click", () => {

    consoleBox.textContent =
        "Console cleared.";

    status.textContent = "Ready";
});


document.getElementById("themeBtn").addEventListener("click", () => {

    document.body.classList.toggle("light");

});


document.getElementById("assistantBtn").addEventListener("click", () => {

    alert(
        "Java Assistant\n\nAsk questions about Java, OOP, JSP, Servlet, JDBC and Spring Boot."
    );

});


const savedCode =
    localStorage.getItem("javaStudioCode");

if (savedCode) {
    editor.value = savedCode;
}
