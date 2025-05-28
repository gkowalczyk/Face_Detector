import React from 'react';

const SideBarMenu = ({ onMenuItemClick }) => {
    return (
        <div className="sidebar">
            <h2 className="sidebar-title">MENU</h2>
            <ul>
                <li onClick={() => onMenuItemClick("analyze")}>🧠 Analiza twarzy</li>
                <li onClick={() => onMenuItemClick("filter")}>🔍 Znajdź w bazie</li>
                <li onClick={() => onMenuItemClick("verify")}>👤 Weryfikacja tożsamości</li>
                <li onClick={() => onMenuItemClick("analyze-video")}>🧠  Weryfikacja tożsamości z video</li>
                <li onClick={() => onMenuItemClick("about")}>ℹ️ O aplikacji</li>

            </ul>
        </div>
    );
};
export default SideBarMenu;