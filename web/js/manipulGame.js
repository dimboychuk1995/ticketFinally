function add_games() {
                        var objTo = document.getElementById('form-game')
                        var divtest = document.createElement("div");
                        divtest.innerHTML = '<div>\n\
                                            <br>\n\
                                            <form  action="../GamesController" method="POST" >\n\
                                             <input type="text" name= "time"    value="" size="3" placeholder = "час"/>\n\
                                            <input type="text" name= "date"    value="" size="20" placeholder = "дата матчу"/>\n\
                                            <input type="text" name= "owner"   value="" size="20" placeholder = "господар"/>\n\
                                            <input type="text" name= "guest"   value="" size="20" placeholder = "гості"/>\n\
                                            <input type="text" name= "place"   value="" size="20" placeholder = "місце проведення"/>\n\
                                            <input id="insertGame" type="hidden" name="insertGame" value="insertGame" />\n\
                                            <button type="submit">зберегти</button>\n\
                                            </form>\n\
                                            </div>';
                        objTo.appendChild(divtest)
                    };
                    
function edit(){    
                var inputs = document.getElementsByClassName('inputs');
                for(var i = 0; i < inputs.length; i++) {
                    inputs[i].disabled = false;
                }                 
                var div = document.getElementsByClassName('buttonEdit');
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
//    var button = document.getElementById(idE);
//    var act = document.forms["form1"];
//    act.action = "../GamesController";
//    act.submit();

}
