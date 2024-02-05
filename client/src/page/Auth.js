import React, { useContext, useState } from "react";
import { Button, Card, Container, Form} from "react-bootstrap";
import Row from "react-bootstrap/Row";
import { NavLink, useLocation, useNavigate } from 'react-router-dom';
import {LOGIN_ROUTE, REGISTRATION_ROUTE, SHOP_ROUTE} from "../utils/consts";
import { login, registration } from "../http/userApi";
import { observer } from "mobx-react-lite";
import { Context } from "..";

const Auth =() => {

    const {user} = useContext(Context)

    const location = useLocation()
    const history = useNavigate()
    const isLogin = location.pathname === LOGIN_ROUTE

    const [phone, setPhone] = useState('')
    const [password,setPassword] = useState('') 
    const [name,setName] = useState('')  


    const click = async ()=>{
        let response
        try{
            if (isLogin){
                response = await login(phone, password)
                console.log(response)
           }
           else{
                response = await registration(phone,password, name)
               console.log(response)
               
           }
           user.setUser(response)
           user.setIsAuth(true)
           history(SHOP_ROUTE)

        }catch(e){
            alert(e)
        }
       
        
    }

    return (
        <Container 
            className="d-flex justify-content-center align-items-center"
            style={{height:window.innerHeight}}
        >
            <Card style={{width:600}} className="p-5">
                <h2 className="m-auto"> {isLogin ? 'Авторизация':'Регистрация'}</h2>
                <Form className="d-flex flex-column">
                    <Form.Control
                        className="mt-2"
                        placeholder="Введите ваш телефон"
                        value={phone}
                        onChange={p=>setPhone(p.target.value)}
                    />
                    <Form.Control
                        className="mt-4"
                        placeholder="Введите ваш пароль"
                        value={password}
                        onChange={p => setPassword(p.target.value)}
                        type="password"
                    />
                    <Row className="d-flex justify-content-between mt-4">
                    {isLogin?
                    <div>
                        Нет аккаунта? <NavLink to={REGISTRATION_ROUTE}>Зарегистрироваться</NavLink>
                    </div>
                    :
                    <div>
                        <Form.Control
                            placeholder="Введите вашe имя"
                            value={name}
                            onChange={p=>setName(p.target.value)}
                        />
                        Уже есть аккаунт? <NavLink to={LOGIN_ROUTE}>Вход</NavLink>
                    </div>
                    }
                    <Button variant={"outline-secondary"} className="mt-4" onClick = {click}>
                        {isLogin? 'Войти':'Регистрация'}
                        
                    </Button>
                    </Row>
                    
                </Form>
            </Card>
            
        </Container>
   );
};

export default Auth;