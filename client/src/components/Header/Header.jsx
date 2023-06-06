import React from 'react'
import "./Header.css"
import logo from "../imgs/1661499491_1-papik-pro-p-stiker-ruki-v-molitve-png-1.svg"
import { Link } from 'react-router-dom'
import { useDispatch, useSelector } from 'react-redux'
import { saveUserInfo, toggleLoggin } from '../../store/slice/userSlice'

const Header = () => {
    const { isLogin } = useSelector(state => state.user);
    const dispatch = useDispatch();


    const handleLogout = () => {
        dispatch(saveUserInfo({}))
        dispatch(toggleLoggin(false));
    }

    return (
        <div className='header'>
            <div className='header-left'>
                <Link className='logo' to='/'> <img className='logo' src={logo} alt="not found" /> </Link>
                <h1 className='headerName'>ДАЙ БОГ РЕШУ</h1>
            </div>
            <div className='registration'>
                {isLogin ? (
                    <React.Fragment>
                        <Link to="/profile" >Профиль</Link>
                        <button onClick={handleLogout}>Выйти</button>
                    </React.Fragment>
                ) : (
                    <React.Fragment>
                        <Link to='/login' className='myButton'>Войти</Link>
                        <Link to='/register' className='myButton'>Зарегестрироваться</Link>
                    </React.Fragment>
                )}

            </div>
        </div>
    )
}

export default Header