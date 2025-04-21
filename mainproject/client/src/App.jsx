import { useState } from 'react'
import 'bootstrap/dist/css/bootstrap.min.css'
import Singup from './singnup'
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Login from './Login';
import Home from './Home';
function App() {


  return (
  
    <div>
    <BrowserRouter>
    <Routes>
      <Route path='/' element={<Singup></Singup>}></Route>
      <Route path='/login' element={<Login></Login>}></Route>
      <Route path='/Home' element={<Home></Home>}></Route>
    </Routes>
    </BrowserRouter>
    </div>
  )
}

export default App
