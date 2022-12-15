import React, { useContext } from 'react';
import { Context } from '..';
import { NavLink } from 'react-router-dom';
import {SHOP_ROUTE} from "../utils/consts";
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Button } from 'react-bootstrap';
import { observer } from 'mobx-react-lite';



const NavBar = observer(() => {  
    const {user}= useContext(Context)
    return (
        <Navbar bg="dark" variant="dark">
          <NavLink style={{color:'white'}} to={SHOP_ROUTE}>Hookah Mafia</NavLink>
          {user.isAuth ?
            <Nav className="ml-auto">
                <Button variant={"outline-secondary"}>Админ панель</Button>
                <Button variant={"outline-secondary"}>Войти</Button>
            </Nav>
          : 
          <Nav className="mr-auto">
                <Button variant={"outline-secondary"} onClick={()=>user.setIsAuth(true)}>Авторизация</Button>
            </Nav>

          }
      </Navbar>
    );
})

export default NavBar;