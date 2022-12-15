import React from "react";
import {Routes , Route} from "react-router-dom"
import Admin from "../page/Admin";
import Auth from "../page/Auth";
import Basket from "../page/Basket";
import DevicePage from "../page/DevicePage";
import Shop from "../page/Shop";
import {ADMIN_ROUTE, SHOP_ROUTE, BASKET_ROUTE,LOGIN_ROUTE,REGISTRATION_ROUTE,DEVICE_ROUTE } from "../utils/consts";

const AppRouter = () => {
    
    return (
       <Routes>
            <Route path={ADMIN_ROUTE} element={<Admin />} />
            <Route path={SHOP_ROUTE} element={<Shop />} />
            <Route path={BASKET_ROUTE} element={<Basket />} />
            <Route path={LOGIN_ROUTE} element={<Auth />} />
            <Route path={REGISTRATION_ROUTE} element={<Auth />} />
            <Route path={DEVICE_ROUTE} element={<DevicePage />} />
            <Route path='*' element={<Shop />} />
       </Routes >

    );
}

export default AppRouter;