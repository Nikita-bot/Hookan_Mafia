import React from "react";
import { useContext } from "react";
import { Context } from "..";
import { Container } from "react-bootstrap/lib/tab";
import { Button } from "react-bootstrap/lib/inputgroup";
import { doPayment } from "../http/basketApi";

const Basket = () => {
    const {user} = useContext(Context)
    if  (user.isAuth){
        return (
            <Container>
                <Button onClick={()=>{doPayment()}}></Button>
            </Container>
        );
    }
    else{
        return(
            <div>Сначала нужно авторизироваться</div>
        );
    }
    
}

export default Basket;