import "./style.css";
import {useEffect, useState} from "react";
import {useLocation, useParams} from "react-router-dom";

const Tests = () => {

    const [tests, setTests] = useState([]);
    const {state: {id}} = useLocation();

    const handleGetTests = async () => {
        const response = await fetch(`http://localhost:8080/api/test?id=${id}`, {
            headers: {
                "content-type": "application/json"
            }
        });
        if (response.status === 200) {
            const data = await response.json();
            setTests(data)
        }
    }

    useEffect(() => {
        handleGetTests()
    }, [])

    return (
        <div className="main">
            {tests.map((test) => (
                <div className="card" key={test.id}>
                    <h3 className="card-text">{test.name}</h3>
                    <span className="card-tests">{test.total}</span>
                </div>)
            )}
        </div>
    )
}

export default Tests;