document.getElementById("proj-id").value = document.getElementById("select-id").value;

function DateCheck()
{
    var StartDate= document.getElementById('begin-time-id').value;
    var EndDate= document.getElementById('end-time-id').value;
    var eDate = new Date(EndDate);
    var sDate = new Date(StartDate);
    if(StartDate!= '' && StartDate!= '' && sDate > eDate)
    {
        alert("Дата начала не может быть больше даты окончания работы.");
        return false;
    }
    return true;
}