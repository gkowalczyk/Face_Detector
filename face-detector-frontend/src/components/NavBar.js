import React from 'react';
import '../NavBar.css';

const Navbar = () => {
    return (
        <nav className="navbar">
            <div className="navbar-logo">🧠 Face Detector</div>
            <ul className="navbar-links">
                <li><a href="/">Strona główna</a></li>
                <li><a href="/login">Logowanie</a></li>
                <li><a href="/register">Rejestracja</a></li>
            </ul>
        </nav>
    );
};

export default Navbar;
