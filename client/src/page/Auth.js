import React from "react";
import { Button, Card, Container, Form} from "react-bootstrap";
import Row from "react-bootstrap/Row";
import { NavLink, useLocation } from 'react-router-dom';
import {LOGIN_ROUTE, REGISTRATION_ROUTE} from "../utils/consts";

const Auth = () => {

    const location = useLocation()
    const isLogin = location.pathname === LOGIN_ROUTE

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
                    />
                    <Form.Control
                        className="mt-2"
                        placeholder="Введите ваш пароль"
                    />
                    <Row className="d-flex justify-content-between mt-4">
                    {isLogin?
                    <div>
                        Нет аккаунта? <NavLink to={REGISTRATION_ROUTE}>Зарегистрироваться</NavLink>
                    </div>
                    :
                    <div>
                        Уже есть аккаунт? <NavLink to={LOGIN_ROUTE}>Вход</NavLink>
                    </div>
                    }
                    <Button variant={"outline-secondary"} className="mt-4">
                        {isLogin? 'Войти':'Регистрация'}
                    </Button>
                    </Row>
                    
                </Form>
            </Card>
            
        </Container>
    );
}
export default Auth;