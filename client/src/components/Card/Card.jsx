import "./style.css"
import logo from "../imgs/pngwing.com.svg"
import {Link, useNavigate} from "react-router-dom"

const Card = ({ id, img, name, totalCountTest }) => {
    const navigate = useNavigate();
    const handelNavigate = () => navigate(`/tests`, {state: {id}});
    return(
        <div onClick={handelNavigate} className="card">
            <div className="card-div-logo">
                <img className="card-logo" src={img} alt="not found" />
            </div>
            <div className="card-text">
                <h3 className="card-h3">{name}</h3>
                <span className="card-tests">{totalCountTest} тестов</span>
            </div>
        </div>
    )
}

export default Card;