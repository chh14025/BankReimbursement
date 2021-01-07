let rankingsBody = document.querySelector("#emp-table > tbody");

function loadRankings(){
    let request = new XMLHttpRequest();
    console.log("getting the js");

    request.open("GET", "http://localhost:8080/ReimbursementProject/bank/ticket");

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
    	
    	th.innerHTML = `
        <button type="button" action="http://localhost:8080/ReimbursementProject/bank/getTicket" class="btn btn-success" id = "approved`+curRow+`" onclick="approve(this.id)"><i class="fas fa-check"></i></button>
        <button type="button" action="http://localhost:8080/ReimbursementProject/bank/getTicket" class="btn btn-danger" id = "rejected`+curRow+`" onclick="reject(this.id)"><i class="fas fa-ban"></i></button>
        `
        tb.innerHTML = ``
        
    
	    Object.keys(row).forEach((cell) => {
	    	//console.log(row[cell]);
	    	//console.log(row.ticketStatus);
	    	let td = document.createElement("td");
	    	td.innerText = row[cell];
			tr.appendChild(td);
			
			
			//tr.appendChild(th);
            
            if(row.ticketStatus == 1){
                tr.appendChild(th);
            }
            else{
                tr.appendChild(tb);
            }
            
            
 

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



function approve(clicked_id){
    let curId = document.getElementById(clicked_id).closest("tr").children[0].innerText
    console.log(curId);    
    
          let xhttp = new XMLHttpRequest();
          let ticketUrl = "http://localhost:8080/ReimbursementProject/bank/ticket";
        
          xhttp.open("PUT", ticketUrl);
        

//        xhttp.onreadystatechange = function(){
   
//             console.log("Changing my readystate " + xhttp.readyState);

//             if(xhttp.readyState == 4 && xhttp.status == 200){
   
                let userData = {
                    ticketStatus : 2,
                    ticketNumber: curId,
                    ticketType: 0,
                    description: "fromjson",
                    submitTime: "time",
                    employeeId: 1
                }
                let jsonString = JSON.stringify(userData);
                console.log(jsonString);
                
                

//             }else if(xhttp.readyState == 4 && xhttp.status != 200){
   				
//                 console.log("We need a number, not whatever your put down");
                 
//             }
   
//        }
   
        
        xhttp.send(jsonString);
        swal("Ticket Approved", "redirecting...", "success");
        setTimeout(function(){
   		window.location.reload(1);
		}, 1000);
}

function reject(clicked_id){
   
    let curId = document.getElementById(clicked_id).closest("tr").children[0].innerText
    console.log(curId);    
    
          let xhttp = new XMLHttpRequest();
          let ticketUrl = "http://localhost:8080/ReimbursementProject/bank/ticket";
        
          xhttp.open("PUT", ticketUrl);
        

//        xhttp.onreadystatechange = function(){
   
//             console.log("Changing my readystate " + xhttp.readyState);

//             if(xhttp.readyState == 4 && xhttp.status == 200){
   
                let userData = {
                    ticketStatus : 0,
                    ticketNumber: curId,
                    ticketType: 0,
                    description: "fromjson",
                    submitTime: "time",
                    employeeId: 1
                }
                let jsonString = JSON.stringify(userData);
                console.log(jsonString);
                
                
//             }else if(xhttp.readyState == 4 && xhttp.status != 200){
   				
//                 console.log("We need a number, not whatever your put down");
                 
//             }
   
//        }
   
        
        xhttp.send(jsonString);
        swal("Ticket Denied", "redirecting...", "success");
        setTimeout(function(){
   		window.location.reload(1);
		}, 1000);
}

