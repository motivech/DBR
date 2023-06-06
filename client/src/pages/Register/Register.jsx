import { useState } from "react";
import './style.css'
import { useNavigate } from "react-router-dom";


const Register = () => {

    const  [login, setLogin] = useState("");
    const  [password, setPassword] = useState("");
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault()
        const data = {login,password}
        const response = await fetch("http://localhost:8080/api/user/register", {
            method: "POST",
            body: JSON.stringify(data),
            headers: {
                "content-type": "application/json"
            }
        })
        if(response.status === 200) {
            navigate("/login")
        }
    } 

    return (
        <form className="form" onSubmit={handleSubmit}>
            <div className="form-input">
                <input className="form-input-text" type="text" placeholder='Login' value={login} onChange={(e) => setLogin(e.target.value)}/>
                <input className="form-input-text" type="password" placeholder='Password' value={password} onChange={(e) => setPassword(e.target.value)}/>
            </div>
            <div className="form-button">
                <button className="input-button" type="submit">Зарегестрироваться</button>
            </div>
        </form>
    )
}

export default Register;