import axios from "axios";


axios.defaults.headers.common['token'] = localStorage.getItem('token')

const $host = axios.create({
    baseURL:'http://localhost:8080/'
})

const $authhost = axios.create({
    baseURL:'http://localhost:8080/',
    headers: {  
        token: localStorage.getItem('token') 
      }
})


$authhost.defaults.headers.post['token'] = localStorage.getItem('token')
$authhost.defaults.headers.get['token'] = localStorage.getItem('token')
$authhost.defaults.headers.common['token'] = localStorage.getItem('token')


export{
    $host,
    $authhost
}