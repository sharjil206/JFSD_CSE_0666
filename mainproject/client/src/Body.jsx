import { useState, useEffect ,useCallback, use} from "react";
function Body() {
    const [profile, setprofile] = useState([]);
    const [noofprofile, setnoofprofile]=useState("")
    const [name , setname]=useState("");
 

const  generateProfile =useCallback(async (count)=>{

    const ran = Math.floor(1 + Math.random() * 1000);
    const response = await fetch(`https://api.github.com/users?since=${ran}&per_page=${count}`);
    const data = await response.json();
    setprofile(data);




},[noofprofile])



   
    const  generatename =useCallback(async(newname)=>{


   
        
            const response = await fetch(`https://api.github.com/users/${newname}`);
        
        const data= await response.json();
        setprofile([data])
          
        
    },[name])




    useEffect(() => {
        generateProfile(10)
    }, [])

console.log("yes n");


    return (

    <div className="but">
  
          <input type="number"  className="input"  min={0}  placeholder="Enter number.." value={noofprofile} onChange={(e)=>{setnoofprofile(e.target.value) ; setname("")}}></input>
          <button className="button1" onClick={()=>{generateProfile(noofprofile)}}>Search Profile</button>
           <input type="text" className="input2" placeholder="Enter name.."  value={name} onChange={(e)=>{setname(e.target.value);setnoofprofile("") }}></input>
            <button className="button1" onClick={()=>{generatename(name)}}>Search Name</button>
           
            <div className="profiles">
            
                
                 {
                    profile.map((value) => {
                        return (
                            <div key={value.id} className="cards">
                                <img className=".img" src={value.avatar_url}></img>
                                <h2 className=".h2">{value.login}</h2>
                                <a href={value.html_url} target="_blank">Profile</a>
                            </div>

                        )
                    }) 


                }

            </div>
            </div>

        
    )


}

export default Body


