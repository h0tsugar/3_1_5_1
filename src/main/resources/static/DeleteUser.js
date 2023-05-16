const formDelete = document.forms["formDeleteUser"];
deleteUser();

async function deleteModalData(id) {
    const modal = new bootstrap.Modal(document.querySelector('#deleteModal'));
    await fillModalWithUserData(formDelete, modal, id);
    switch (formDelete.roles.value) {
        case '1':
            formDelete.roles.value = 'ADMIN';
            break;
        case '2':
            formDelete.roles.value = 'USER';
            break;
    }
}

function deleteUser() {
    formDelete .addEventListener("submit", ev => {
        ev.preventDefault();
        fetch("http://localhost:8080/api/admin/" + formDelete.id.value + "/user", {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(() => {
            $('#deleteFormCloseButton').click();
            userTable();
        });
    });
}

function loadRolesDelete() {
    let select = document.getElementById("roleDelete");
    select.innerHTML = "";

    fetch("http://localhost:8080/api/admin/roles")
        .then(res => res.json())
        .then(data => {
            data.forEach(role => {
                let option = document.createElement("option");
                option.value = role.id;
                option.text = role.role === "ROLE_USER" ? "USER" : role.role === "ROLE_ADMIN" ? "ADMIN" : role.name;
                select.appendChild(option);
            });
        })
        .catch(error => console.error(error));
}

window.addEventListener("load", loadRolesDelete);

