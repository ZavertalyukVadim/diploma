function deleteComm(id) {
    $.ajax({
        async: false,
        type: "GET",
        url: "/ajaxtest/" + id
    })
}