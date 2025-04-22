import React from 'react';

const SideBarMenu = ({ onMenuItemClick }) => {
    return (
        <div className="sidebar">
            <h2 className="sidebar-title">MENU</h2>
            <ul>
                <li onClick={() => onMenuItemClick("analyze")}>🧠 Analiza z URL</li>
                <li onClick={() => onMenuItemClick("filter")}>🔍 Znajdź w bazie</li>
                <li onClick={() => onMenuItemClick("verify")}>👤 Zweryfikuj twarz</li>
                <li onClick={() => onMenuItemClick("about")}>ℹ️ O aplikacji</li>

            </ul>
        </div>
    );
};
export default SideBarMenu;