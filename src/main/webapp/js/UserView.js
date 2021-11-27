class UserView{



    //State
    constructor(user){
        this.user = user;
        this.block = null;
        //Object.seal(this);
    }


    //Metodos
    render = (container)=>{

        //String -> HTML DOM

        let div = document.createElement("div"); //DOM

        let html = `<div class="card card-margin w-50">
                        <div class="card-body">
                            <h5 class="card-title">${this.user.name}</h5>
                            <p class="card-text">Tiene ${this.user.age} años</p>
                            <a id="${this.user.id}" href="#" class="btn btn-danger">Bloquear</a>
                        </div>
                    </div>`;
        div.innerHTML = html; //<div> <div class="card">...</div> </div>

        //text-white bg-secondary

        let card = div.firstChild; // <div class="card">...</div> DOM HTML
        if(this.user.blocked === true){
            card.classList.add("text-white");
            card.classList.add("bg-secondary");
        }

        container.appendChild(card);

        //Eventos a la card
        let blockBtn = document.getElementById(this.user.id);
        blockBtn.addEventListener("click", (e)=>{
            e.preventDefault();
            alert(this.user.name);
        });
    }

    /*
    block = ()=>{
        alert("Bloquear a "+this.user.name);
    }
    */



}