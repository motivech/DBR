import "./style.css";
import Card from "../../components/Card/Card";
import { useEffect, useState } from "react";

const Main = () => {
  const [cards, setCards] = useState([]);

  const handleGetSchoolSubjects = async () => {
    const response = await fetch("http://localhost:8080/api/school-subjects");
    if(response.status === 200) {
      const data = await response.json();
      setCards(data);
    }
  }

  useEffect(() => {
    handleGetSchoolSubjects();
  }, [handleGetSchoolSubjects])

   return (
    <div className="main">
      {
        cards.map((card) => <Card key={card.id} {...card}/>)
      }
    </div>
   )
}

export default Main;