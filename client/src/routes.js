import Admin from "./page/Admin"
import Auth from "./page/Auth"
import Basket from "./page/Basket"
import ProductPage from "./page/ProductPage"
import Shop from "./page/Shop"
import { ADMIN_ROUTE, BASKET_ROUTE, DEVICE_ROUTE, LOGIN_ROUTE, REGISTRATION_ROUTE, SHOP_ROUTE } from "./utils/consts"

export const authRouters = [
    {
        path : ADMIN_ROUTE,
        Component : Admin
    },
    {
        path : BASKET_ROUTE,
        Component : Basket
    },
]
export const publicRouters = [
    {
        path : SHOP_ROUTE,
        Component : Shop
    },
    {
        path : LOGIN_ROUTE,
        Component : Auth
    },{
        path : REGISTRATION_ROUTE,
        Component : Auth
    },
    {
        path : DEVICE_ROUTE + "/:id",
        Component : ProductPage
    },
]
