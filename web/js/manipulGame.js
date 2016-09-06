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


function addGame(){
    $('#addGameJS').load('addGame.jsp');
}
$(function() {
    $('#selectGameTime').change(function() {
        this.form.submit();
    });
});

function deleteGameAjax(id) {
        var msg   = $('#formDeleted' + id).serialize();
    $.ajax({
        type: 'POST',
        url: '../GamesController',
        data: msg,
    success: function(data) {
        $('#results').html(data); 
        var row = document.getElementById(id);
        var table = row.parentNode;
        while ( table && table.tagName != 'TABLE' )
            table = table.parentNode;
            if ( !table )
            return;
        table.deleteRow(row.rowIndex);
    },
    error:  function(xhr, str){
        alert('Помилка видалення даних: ' + xhr.responseCode);
    }
  });
}

function deleteRow(r) {
    var i = r.parentNode.parentNode.rowIndex;
    document.getElementById("tableGame").deleteRow(i);
}



