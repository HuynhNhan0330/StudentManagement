import React, { useEffect, useRef } from 'react';
import { DollarCircleOutlined, ShoppingCartOutlined, ShoppingOutlined, UserOutlined } from '@ant-design/icons';
import { Card, Space, Statistic, Table, Typography, Row, Col } from 'antd';
import Chart from 'chart.js/auto';
import './Home.scss';

function Home() {
    const barChartRef = useRef(null);
    const pieChartRef = useRef(null);

    useEffect(() => {
        // Biểu đồ Bar Chart
        const barCtx = barChartRef.current.getContext('2d');
        const barChart = new Chart(barCtx, {
            type: 'bar',
            data: {
                labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
                datasets: [
                    {
                        label: '# of Votes',
                        data: [12, 19, 3, 5, 2, 3],
                        borderWidth: 1,
                    },
                ],
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true,
                    },
                },
            },
        });

        // Biểu đồ Pie Chart
        const pieCtx = pieChartRef.current.getContext('2d');
        const pieChart = new Chart(pieCtx, {
            type: 'doughnut',
            data: {
                labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
                datasets: [
                    {
                        data: [12, 19, 3, 5, 2, 3],
                        backgroundColor: ['red', 'blue', 'yellow', 'green', 'purple', 'orange'],
                    },
                ],
            },
        });

        // Hủy biểu đồ khi component unmount
        return () => {
            barChart.destroy();
            pieChart.destroy();
        };
    }, []);

    const renderDashboardCard = (title, value, icon, iconColor) => (
        <Col xs={24} sm={12} md={6} lg={6}>
            <DashBoardCard icon={icon} title={title} value={value} iconColor={iconColor} />
        </Col>
    );

    return (
        <div>
            <div>
                <Row gutter={[16, 16]}>
                    {renderDashboardCard('Total', 100000, <ShoppingCartOutlined />, 'green')}
                    {renderDashboardCard('Revenue', 50000, <DollarCircleOutlined />, 'blue')}
                    {renderDashboardCard('Items Sold', 200, <ShoppingOutlined />, 'orange')}
                    {renderDashboardCard('Customers', 50, <UserOutlined />, 'purple')}
                </Row>
            </div>
            <div className="pt-5">
                <Row gutter={[16, 16]}>
                    <Col xs={24} sm={12} md={12} lg={12}>
                        <Card>
                            <h5 style={{ textAlign: 'center' }}>Biểu đồ Bar Chart</h5>
                            <canvas id="barChart" ref={barChartRef}></canvas>
                        </Card>
                    </Col>
                    <Col xs={24} sm={12} md={12} lg={12}>
                        <Card>
                            <h5 style={{ textAlign: 'center' }}>Biểu đồ Pie Chart</h5>
                            <canvas id="pieChart" ref={pieChartRef}></canvas>
                        </Card>
                    </Col>
                </Row>
            </div>
        </div>
    );
}

function DashBoardCard({ title, value, icon, iconColor }) {
    const iconStyle = {
        color: iconColor,
        backgroundColor: 'rgba(0,255,0,0.25)',
        borderRadius: 20,
        fontSize: 24,
        padding: 8,
    };

    return (
        <div
            style={{
                padding: '16px',
                backgroundColor: '#fff',
                borderRadius: '8px',
                boxShadow: '0 2px 8px rgba(0, 0, 0, 0.1)',
            }}
        >
            <div style={{ display: 'flex', alignItems: 'center' }}>
                {React.cloneElement(icon, { style: iconStyle })}
                <Statistic title={title} value={value} />
            </div>
        </div>
    );
}

export default Home;
