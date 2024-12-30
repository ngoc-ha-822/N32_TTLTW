function showNo() {
    document.getElementById("information").style.display = "none";
    document.getElementById("notify_account").style.display = "block";
    document.getElementById("order").style.display = "none";
    document.getElementById("voucher").style.display = "none";
}

function showInformation() {
    document.getElementById("information").style.display = "block";
    document.getElementById("notify_account").style.display = "none";
    document.getElementById("order").style.display = "none";
    document.getElementById("voucher").style.display = "none";
}

function showOrder() {
    document.getElementById("information").style.display = "none";
    document.getElementById("notify_account").style.display = "none";
    document.getElementById("order").style.display = "block";
    document.getElementById("voucher").style.display = "none";
}

function showVoucher() {
    document.getElementById("information").style.display = "none";
    document.getElementById("notify_account").style.display = "none";
    document.getElementById("order").style.display = "none";
    document.getElementById("voucher").style.display = "block";
}