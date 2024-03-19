import React, { useContext, useEffect, useState } from "react";
import { BrowserRouter } from "react-router-dom";
import AppRouter from "./components/AppRouter";
import NavBar from "./components/NavBar";
import 'bootstrap/dist/css/bootstrap.min.css';
import { observer } from 'mobx-react-lite';
import { Context } from ".";
import { check } from "./http/userApi";
import { Spinner } from "react-bootstrap";
import ProductPriceWebSocket from "./websocket/ProductPriceWebSocket";

const App = observer(() => {
  const {user} = useContext(Context)
  const [loading, setLoading] = useState(true)
  //useEffect - сообщаем что делать после рендра
  useEffect(()=>{
    check().then(data =>{
      user.setUser(true)
      user.setIsAuth(true)
    }).finally(()=>setLoading(false)); },[])

    if(loading){
      return <Spinner animation={"grow"}/>
    }
  return(
    <BrowserRouter>
      <NavBar/>
      <AppRouter/>
      <ProductPriceWebSocket/>
    </BrowserRouter>
  );
})
export default App;
