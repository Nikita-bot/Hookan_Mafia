import React from "react";
import { useContext } from "react";
import { Context } from "..";

const Basket = () => {
    const {user} = useContext(Context)
    if  (user.isAuth){
        return (
            <div>
                Basket
            </div>
        );
    }
    else{
        return(
            <div>Сначала нужно авторизироваться</div>
        );
    }
    
}

export default Basket;