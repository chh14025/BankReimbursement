let rankingsBody = document.querySelector("#emp-table > tbody");

function loadRankings(){
    let request = new XMLHttpRequest();
    console.log("getting the js");

    request.open("GET", "http://localhost:8080/ReimbursementProject/bank/employee");

    request.onload = () => {
        try{
	        //console.log(request.responseText);
	        const json = JSON.parse(request.responseText);
	        //console.log(json);
	        populateRankings(json);
	        alterValue(json);
	        
        }catch(e){
            console.warn("could not load rankings");
        }
    }

    request.send();
    
}


function populateRankings(json){

    console.log("in populate Ranking");
    //clear child data
    while(rankingsBody.firstChild){
       rankingsBody.removeChild(rankingsBody.firstChild);
    }
    json.forEach((row) => {
    //console.log(row);
    	let tr = document.createElement("tr");
    	let th = document.createElement("th");
    	let tb = document.createElement("th");
        let thisRow = json.indexOf(row)+1;
    	let curRow = ''+thisRow
        console.log(typeof(curRow));
 
    
	    Object.keys(row).forEach((cell) => {
	    	//console.log(row[cell]);
	    	//console.log(row.ticketStatus);
	    	let td = document.createElement("td");
	    	td.innerText = row[cell];
			tr.appendChild(td);
			

	    	});
	    	
	    	rankingsBody.appendChild(tr)
	    	
    
    });
    
}


function alterValue(json){

    json.forEach((row) => {
        let currentRow = json.indexOf(row)+1;

        let ticketTable = document.getElementById("emp-table")
        let status = ticketTable.rows[currentRow].cells[1].innerHTML
        let type = ticketTable.rows[currentRow].cells[2].innerHTML


        if (status == 1){
            ticketTable.rows[currentRow].cells[1].innerHTML = 'Pending';
        } else if(status == 2){
            ticketTable.rows[currentRow].cells[1].innerHTML = 'Approved';
        } else if(status == 0){
            ticketTable.rows[currentRow].cells[1].innerHTML = 'Rejected';
        } else{
            ticketTable.rows[currentRow].cells[1].innerHTML = 'Unknown Status';
            console.log("invalid number");
        }

        if (type == 1){
            ticketTable.rows[currentRow].cells[2].innerHTML = 'Lodging';
        } else if(type == 2){
            ticketTable.rows[currentRow].cells[2].innerHTML = 'Travel';
        } else if(type == 3){
            ticketTable.rows[currentRow].cells[2].innerHTML = 'Food';
        } else if(type == 4){
            ticketTable.rows[currentRow].cells[2].innerHTML = 'Ohter';
        } else {
            ticketTable.rows[currentRow].cells[2].innerHTML = 'Unknown Type';
        }
    
    })

}
document.addEventListener("DOMContentLoaded", ()=> {loadRankings();})


