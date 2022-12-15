import { makeAutoObservable } from "mobx"

export default class DeviceStore{
    constructor(){
        this._types = [
            {id:1,name:"HOLODILNIC"},
            {id:2,name:"SMARTPHONE"}
        ]
        this._brands = [
            {id:1,name:"Toshiba"},
            {id:2,name:"Samsung"}
        ]
        this._device = [
            {id:1,name:"Iphone 12 pro",price:"1000",strength:"10",img:"https://burntobacco.com/wp-content/uploads/2021/11/BlackBurn-pachka.png"},
            {id:1,name:"Iphone 13 pro",price:"1001",strength:"9",img:"https://burntobacco.com/wp-content/uploads/2021/11/BlackBurn-pachka.png"},
            {id:1,name:"Iphone 14 pro",price:"1002",strength:"8",img:"https://burntobacco.com/wp-content/uploads/2021/11/BlackBurn-pachka.png"},
            {id:1,name:"Iphone 15 pro",price:"1003",strength:"7",img:"https://burntobacco.com/wp-content/uploads/2021/11/BlackBurn-pachka.png"},
            {id:1,name:"Iphone 16 pro",price:"1004",strength:"6",img:"https://burntobacco.com/wp-content/uploads/2021/11/BlackBurn-pachka.png"},
        ]
        makeAutoObservable(this)
    }

    get types(){
        return this._types
    }

    setTypes(types){
        this._types = types
    }

    get brans(){
        return this._brans
    }

    setBrands(brands){
        this._brands = brands
    }

    get devices(){
        return this._devices
    }

    setDevices(devices){
        this._devices = devices
    }
}