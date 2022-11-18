import axios from 'axios';
import { toast } from 'react-toastify';
import NotificationIcon from '../../assets/img/notification-icon.svg'
import { BASE_URL } from '../../utils/request';
import './style.css'

type Props ={
    saleId: number;
}

function handleClick(saleId: number){
    axios.get(`${BASE_URL}/sales/${saleId}/notification`)
        .then(response => {
            toast.info("SMS enviado com sucesso!")
        })
}


function NotificationButton({ saleId } : Props) {
    return (
        <div className="dsmeta-red-btn" onClick={() => handleClick(saleId)}>
            <img src={NotificationIcon} alt="Notificar" />
        </div>
    )
}

export default NotificationButton