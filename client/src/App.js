import { useEffect, useState } from 'react';
import './App.css';
import AppRouter from './routes/AppRouter';

function App() {

  // useEffect(()=>{
  //   fetch("http://localhost:8080/users",{}).then((response) => response.json()).then(data => console.log(data))
  // },[])
  
  const [isAuth, setAuth] = useState(localStorage.getItem("auth") || false);

  return (
    <AppRouter />
  );
}

export default App;
