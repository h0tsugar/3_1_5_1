async function getUserId(id) {
    let url = "http://localhost:8080/api/admin/" + id + "/user";
    let response = await fetch(url);
    return await response.json();
}