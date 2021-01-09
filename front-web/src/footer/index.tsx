import './styles.css';
import { ReactComponent as InstagramLogo} from './instagram.svg';
import { ReactComponent as LinkedinLogo} from './linkedin.svg';
import { ReactComponent as YoutubeLogo} from './youtube.svg';

function Footer(){
    return(
        <footer className="main-footer">
            <p>App desenvolvido durante a 2ª ed. do evento Semana DevSuperior</p>
            <div className="footer-icons">
                <a href="https://www.youtube.com/c/DevSuperior" target="__new">
                    <YoutubeLogo />
                </a>
                <a href="https://www.linkedin.com/school/devsuperior/" target="__new">
                    <LinkedinLogo />
                </a>
                <a href="https://www.instagram.com/devsuperior.ig/" target="__new">
                    <InstagramLogo />
                </a>
            </div>
        </footer>
    )
}

export default Footer;