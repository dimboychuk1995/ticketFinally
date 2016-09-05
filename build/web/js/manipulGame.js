function edit(){    
                var inputs = document.getElementsByClassName('col-xs-12');
                for(var i = 0; i < inputs.length; i++) {
                    inputs[i].disabled = false;
                }                 
                var div = document.getElementsByClassName('btn btn-mini btn-warning');
                for (var j = 0; j < div.length; j++){
                
                    if(div[j].style.display == 'none') {
                        div[j].style.display = 'block';
                    }
                    else {
                        div[j].style.display = 'block';
                    }  
                }      
        };

function sbmit(iForm){
    
    iForm.submit();
}
function addGame(){
    $('#addGameJS').load('addGame.jsp');
}
$(function() {
    $('#selectGameTime').change(function() {
        this.form.submit();
    });
});



