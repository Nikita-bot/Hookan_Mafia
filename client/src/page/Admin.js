import React, { useContext } from "react";
import { Context } from "..";

const Admin = () => {
    const {user} = useContext(Context)
    console.log(user.isAuth)
    if  (user.isAuth){
        return (
            <div>
                Admin
            </div>
        );
    }
    else{
        return(
            <div>У тебя нет прав</div>
        );
    }
    
}

export default Admin;